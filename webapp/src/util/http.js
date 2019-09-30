import axios from 'axios'
import appConst from './appConst'

const CancelToken = axios.CancelToken
const source = CancelToken.source()
axios.interceptors.response.use((response) => {
  const code = response.data.code
  if (code !== 200) {
    // 某个请求的响应满足特定条件的情况下，取消其他正在进行的请求
    source.cancel()
  }
  return Promise.resolve(response)
}, (error) => {
  if (axios.isCancel(error)) { // 取消请求的情况下，终端Promise调用链
    return new Promise(() => {
    })
  } else {
    return Promise.reject(error)
  }
})

export const get = (url, query) => {
  const token = window.localStorage.token
  let _url
  if (query) {
    _url = `${appConst.BACKEND_DOMAIN}${url}?${query}`
  } else {
    _url = `${appConst.BACKEND_DOMAIN}${url}`
  }
  return axios.get(_url, {
    headers: {token}
  })
    .then((res) => {
      return res.data
    })
    .catch((err) => {
      errorProcess(err)
      return Promise.reject(err)
    })
}

export const post = (url, query) => {
  const token = window.localStorage.token
  let _url = `${appConst.BACKEND_DOMAIN}${url}`
  return axios.post(_url, query, {
    headers: {token}
  })
    .then((res) => {
      return res.data
    })
    .catch((err) => {
      errorProcess(err)
      return Promise.reject(err)
    })
}

export const put = (url, query) => {
  const token = window.localStorage.token
  let _url = `${appConst.BACKEND_DOMAIN}${url}`
  return axios.put(_url, query, {
    headers: {token}
  })
    .then((res) => {
      return res.data
    })
    .catch((err) => {
      errorProcess(err)
      return Promise.reject(err)
    })
}

export const patch = (url, query) => {
  const token = window.localStorage.token
  let _url = `${appConst.BACKEND_DOMAIN}${url}`
  return axios.patch(_url, query, {
    headers: {token}
  })
    .then((res) => {
      return res.data
    })
    .catch((err) => {
      errorProcess(err)
      return Promise.reject(err)
    })
}

export const del = (url, article) => {
  const token = window.localStorage.token
  let _url = `${appConst.BACKEND_DOMAIN}${url}/${article._id}`
  return axios.delete(_url, {
    headers: {token}
  })
    .then((res) => {
      return res.data
    })
    .catch((err) => {
      errorProcess(err)
      return Promise.reject(err)
    })
}

const errorProcess = (err) => {
  if (err.response.status === 401) {
    window.location.href = '#/login'
  }
}
