import urllib.request


def load_baidu():
    url = "https://www.baidu.com"
    header = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; \
                     Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"
    }
    request = urllib.request.Request(url, headers=header)
    response = urllib.request.urlopen(request)
    data = response.read().decode("utf-8")
    request_header = request.headers
    print(request_header)
    with open("header.html", "w", encoding="utf-8")as f:
        f.write(data)


load_baidu()
