import requests


class RequestsSpider(object):
    def __init__(self):
        url = "https://www.baidu.com"
        headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36'
        }
        self.response = requests.get(url, headers=headers)

    def RequestIfo(self):

        data = self.response.request
        request_headers = self.response.request.headers
        print("request header is :", request_headers)
        response_headers = self.response.headers
        print("response headers is : ", response_headers)
        code = self.response.status_code
        print("Status code is : ", code)

        request_cookies = self.response.request._cookies
        print("Request cookies is : ", request_cookies)

        response_cookies = self.response.cookies
        print("Response cookies is : ", response_cookies)


RequestsSpider().RequestIfo()



