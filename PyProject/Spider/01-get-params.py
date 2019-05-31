import urllib.request
import string
import urllib.parse


def get_params():
    url = "http://www.baidu.com/s?"
    params = {
        "wd": "中文",
        "key": "zhang",
        "value": "san"

    }
    str_params = urllib.parse.urlencode(params)     # 把字典参数中的冒号转换为等号
    component_url = url + str_params
    print(component_url)
    final_url = urllib.parse.quote(component_url, safe=string.printable)   # 将带有中文的url转化为计算机可识别的url
    response = urllib.request.urlopen(final_url)
    print(final_url)
    data = response.read().decode("utf-8")
    with open("baidu-search.html", "w", encoding="utf-8") as f:
        f.write(data)


get_params()
