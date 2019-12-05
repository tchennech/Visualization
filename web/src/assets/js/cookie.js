export function setCookie (cookieName, value, expire) {
  var date = new Date()
  date.setSeconds(date.getSeconds() + expire)
  document.cookie = cookieName + '=' + escape(value) + '; expires=' + date.toGMTString()
  console.log(document.cookie)
}

export function getCookie (cookieName) {
  if (document.cookie.length > 0) {
    let cookieStart = document.cookie.indexOf(cookieName + '=')
    if (cookieStart !== -1) {
      cookieStart = cookieStart + cookieName.length + 1
      let cookieEnd = document.cookie.indexOf(';', cookieStart)
      if (cookieEnd === -1) cookieEnd = document.cookie.length
      return unescape(document.cookie.substring(cookieStart, cookieEnd))
    }
  }
  return ''
}

export function delCookie (cookieName) {
  setCookie(cookieName, '', -1)
}
export function getUser () {
  let uerTemp = getCookie('user')
  if (uerTemp == null || uerTemp === '' || uerTemp === undefined) {
    this.$router.push('/login')
  } else {
    return JSON.parse(uerTemp)
  }
}
