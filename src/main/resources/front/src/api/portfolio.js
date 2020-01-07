import http from './public'

export default {
  getIndices(){
    return http.simpleGet('/indices');
  },
  getItems(params){
    return http.get('/items', params)
  },
  getStockDetail(params){
    return http.get('/stock/detail', params)
  },
  getPortfolio(id){
    return http.simpleGet('/portfolio/' + id)
  },
  getPortfolios(managerId, params){
    return http.get('/portfolio/' + managerId, params)
  },
  addPortfolio(params){
    return http.post('/portfolio', params)
  },
  buy(params){
    return http.post('/position', params)
  },
  getPerformance(type, name,params){
    return http.get('/' + type + '/' + name, params)
  },
  getPortByMangerId() {
    // return http.get();
  },
  assignTo(params) {
    return http.post('/portfolio/manager',params)
  },

  getRank() {
    return http.get('/managerRanks')
  }
}
