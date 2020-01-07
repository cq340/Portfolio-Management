import http from './public'

export default {
  getPositionDetail(id){
    return http.simpleGet("/position/" + id);
  },
  getPositions(portfolioId, params){
    return http.get("/position/portfolio/" + portfolioId, params)
  },
  sell(params) {
    return http.post('/position/sell', params);
  },
  buy(params) {
    return http.post('/position', params);
  },
}
