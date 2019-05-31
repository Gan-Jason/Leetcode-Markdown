import urllib.request

def proxy_user():
    proxy_list = [
        {"http": "112.87.71.119:9999"},
        {"http": "139.214.27.136:80"},
        {"https": "116.209.57.241:9999"},
        {"http": "112.85.131.242:9999"},
        {"http": "112.85.169.58:9999"}
    ]
    for proxy in proxy_list:
        proxy_handler = urllib.request.ProxyHandler(proxy)
        opener = urllib.request.build_opener(proxy_handler)
        try:
            response = opener.open("http://www.baidu.com", timeout=1)
            print("successful")
        except Exception as e:
            print(e)


proxy_user()
