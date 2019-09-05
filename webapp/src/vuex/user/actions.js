import api from '../../api/user'

export const login = ({commit}, userInfo) => {
  api.login(userInfo).then((res) => {
    if (res.code === 200) {
      commit('SET_ERROR_INFO', '')
      window.localStorage.setItem('token', res.data.token)
      window.localStorage.setItem('loginId', userInfo.loginId)
      window.location.replace('#/themeList')
    } else {
      commit('SET_ERROR_INFO', res.data.errMsg)
    }
  })
}

export const register = ({commit}, userInfo) => {
  api.register(userInfo)
    .then((res) => {
      if (res.code === 200) {
        window.localStorage.setItem('token', res.data.token)
        window.location.replace('#/themeList')
      } else {
        commit('SET_ERROR_INFO', res.data.errMsg)
      }
    })
}

export const logout = ({commit}) => {
  return api.logout()
}
