import requests


url = "http://www.baidu.com"
response = requests.get(url)
print(response.content)

