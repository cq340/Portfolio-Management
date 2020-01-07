import http from './public'

export default {
  login(params) {
    return http.post('/login', params);
  },
  logout(params) {
    return http.get('/logout', params)
  },
  getManagers(params){
    return http.get('/manager', params)
  },
  addManager(params){
    return http.post('/manager', params)
  },
  modifyManager(params){
    return http.put('/manager',params)
  },
  removeManager(id){
    return http.delete('/manager/' + id)
  }
}
