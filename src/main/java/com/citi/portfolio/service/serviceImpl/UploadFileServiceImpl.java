package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.CommoditiesMapper;
import com.citi.portfolio.dao.StocksMapper;
import com.citi.portfolio.model.Commodities;
import com.citi.portfolio.model.Stocks;
import com.citi.portfolio.service.serviceInterface.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

/**
 * Created by changqing on 2018/8/15.
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {
    private static String UPLOADED_FOLDER = "/Users/changqing/Documents/files";
    String filename;
    @Autowired
    private StocksMapper stocksMapper;

    @Autowired
    private CommoditiesMapper commoditiesMapper;

    @Autowired
    private Stocks stocks;

    @Autowired
    private Commodities commodities;

    /**
     * 保存用户上传的文件
     * @param file
     * @return
     */
    @Override
    public boolean saveFile(MultipartFile file) {
        try {
            // 获取文件并保存到指定文件夹中
            byte[] bytes = file.getBytes();
            filename = file.getOriginalFilename();
            //check whether the file is a csv file or not
            String fileType = filename.substring(filename.lastIndexOf(".") + 1);
            if (!fileType.equals("csv")) {
                return false;
            }
            Path path = Paths.get(UPLOADED_FOLDER + filename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    /**
     * 读取已保存的文档,并把数据保存在数据库
     * @param type
     * @return
     */
    @Override
    public boolean readFile(String type) {
        // 解析文件
        BufferedReader br = null;
        FileReader reader = null;
        try {
            reader = new FileReader(UPLOADED_FOLDER + filename);
            br = new BufferedReader(reader);
            String line = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
            int cnt = 0;

            while ((line = br.readLine()) != null) {
                cnt++;
                //跳过首行,首行都是field的名称,不是数据
                if (cnt > 1) {
                    String[] items = line.trim().split(",");
                    if (type.equals("Stock")) {
                        stocks.setStocksName(items[0]);
                        stocks.setStocksDate(sdf.parse(items[1]));
                        stocks.setPrice(Double.parseDouble(items[2]));
                        stocks.setOpenPrice(Double.parseDouble(items[3]));
                        stocks.setHighPrice(Double.parseDouble(items[4]));
                        stocks.setLowPrice(Double.parseDouble(items[5]));
                        stocks.setVol(Double.parseDouble(items[6]));
                        stocksMapper.insertSelective(stocks);

                    } else {
                        commodities.setCommoditiesName(items[0]);
                        commodities.setCommDate(sdf.parse(items[1]));
                        commodities.setPrice(Double.parseDouble(items[2]));
                        commodities.setOpenPrice(Double.parseDouble(items[3]));
                        commodities.setHighPrice(Double.parseDouble(items[4]));
                        commodities.setLowPrice(Double.parseDouble(items[5]));
                        commodities.setVol(Double.parseDouble(items[6]));
                        commoditiesMapper.insertSelective(commodities);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
