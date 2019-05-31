import urllib.request


def handler_opener():
    url = "https://www.bilibili.com/"
    # urllib.request.urlopen(url)
    handler = urllib.request.HTTPHandler()
    opener = urllib.request.build_opener(handler)
    response = opener.open(url)
    data = response.read().decode("utf-8")
    # print(data)
    with open("b_data.html", "w", encoding="utf-8")as f:
        f.write(data)


handler_opener()
