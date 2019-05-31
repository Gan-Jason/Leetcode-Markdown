import requests
from bs4 import BeautifulSoup
import lxml.html
import json
import pymysql


class DoubanSpider(object):

    def __init__(self):
        self.url = "https://www.douban.com/search?q=%E7%8E%8B%E5%AE%B6%E5%8D%AB%E7%94%B5%E5%BD%B1"
        self.header = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"
        }
        self.cookie = "ll=\"108296\"; bid=6pEaPOXKB-4; __utmz=30149280.1558968567.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __yadk_uid=qMiFT9SjUOYCyHo3fqIt3Jpy1aCDmJ0G; push_noty_num=0; push_doumail_num=0; __utmv=30149280.14759; douban-profile-remind=1; __gads=ID=73b81ded4e2921aa:T=1558969118:S=ALNI_MaTRq37fmhVb_Z4A8Rm4BkoVgF7KQ; ps=y; _pk_ses.100001.8cb4=*; __utma=30149280.1632186615.1558968567.1559032241.1559043287.3; __utmc=30149280; __utmt=1; dbcl2=\"147591365:0pvLpR4iRfA\"; ck=rddj; ap_v=0,6.0; __utmb=30149280.3.10.1559043287; _pk_id.100001.8cb4=3fdcff93e47f23e9.1558968566.3.1559043345.1559033621"
        self.cookiedic={}
        self.cookie = self.cookie.split(";")
        self.Movielist=[]
        self.connect = pymysql.connect(
            host="localhost",
            user="root",
            passwd="",
            database="MrWang'sMovie",
            port="3306",
            charset="utf-8"

        )
        self.cur = pymysql.cursors()

    def GetResponse(self, url):
        for cookie in self.cookie:
            self.cookiedic[cookie.split("=")[0]] = cookie.split("=")[1]
        response = requests.get(url, headers=self.header, cookies=self.cookiedic)
        data = response.content.decode()
        return data

    def ParseData(self, data):
        # soup = BeautifulSoup(data, "lxml")
        etree = lxml.html.etree
        ParseData = etree.HTML(data)
        MovieList = ParseData.xpath('//div/h3[span="[电影]"]/a[@target="_blank"]/text()')
        MovieContent = ParseData.xpath('///div/h3[span="[电影]"]/a[@target="_blank"]/ancestor::div/parent::div/p/text()')
        ContentUrlList = ParseData.xpath('///div/h3[span="[电影]"]/a[@target="_blank"]/ancestor::div/parent::div/preceding-sibling::div/a/@href')
        i = 0
        j = 0
        for name in MovieList:
            MovieDict = {}
            MovieDict["MovieName"] = name
            MovieDict["MovieContent"] = MovieContent[i]
            i += 1
            MovieDict["MovieUrl"] = ContentUrlList[j]
            j += 1
            InsertSM = 'insert into MrWang\'sMovie <name,url,content> value<{},{},{}>;'.format(name, ContentUrlList[j], MovieContent[i])
            self.cur.execute(InsertSM)
            self.Movielist.append(MovieDict)

    def SaveData(self):
        json.dump(self.Movielist, open("Douban.json", "w"))

    def RunSpider(self):
        url = self.url          # .format(王家卫电影)
        data = self.GetResponse(url)
        self.ParseData(data)
        self.SaveData()


DoubanSpider().RunSpider()



