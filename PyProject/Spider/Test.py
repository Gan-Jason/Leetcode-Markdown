import urllib.request
import urllib.parse
import string


def get_params():
    url = "http://www.baidu.com"
    '''params={
            "wd":"中文",
            "key":"zhang",
            "value":"san"
    } '''
    # name="美女"
    response = urllib.request.urlopen(url)
    data = response.read().decode()
    with open("encode.html", "w", encoding="utf-8") as f:
        f.write(data)

get_params()




