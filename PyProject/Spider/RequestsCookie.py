import requests


class RequestCookie():
    def __init__(self):
        self.url = "https://space.bilibili.com/423443670"
        self.headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36'
        }
        self.cookie = "buvid3=9D7EDEB6-1D2B-4947-923A-AA03014D5D1B110236infoc; LIVE_BUVID=AUTO4715579360852356; sid=idfb0eo8; DedeUserID=423443670; DedeUserID__ckMd5=067d742bcfc0c10e; SESSDATA=18f91d9c%2C1560528094%2C9bec4151; bili_jct=6df31c1ea69fc8f93d73d5425076316a; finger=b3372c5f; im_notify_type_423443670=0; _uuid=CF09A50B-92AD-DD61-87FF-AD421CF68ECE05139infoc; UM_distinctid=16ae01323b1175-0682c9534072b-353166-144000-16ae01323b2c27; stardustvideo=1; CURRENT_FNVAL=16; rpdid=|(umu)J~ul)m0J'ull)YukRll; bp_t_offset_423443670=257070732017952951; _dfcaptcha=df4dd3aa7f4d010372c64613ba8d8428; fts=1558966450; CNZZDATA2724999=cnzz_eid%3D181016458-1558534455-https%253A%252F%252Fsearch.bilibili.com%252F%26ntime%3D1558962158"

    def getrequest(self):

        Cookie_Dict = {}
        cookie_list = self.cookie.split(';')
        for cookie in cookie_list:
            Cookie_Dict[cookie.split("=")[0]] = cookie.split("=")[1]
        print(Cookie_Dict)
        response = requests.get(self.url, headers=self.headers, cookies=Cookie_Dict)
        print(response.status_code)
        with open("bilibili2.html", "w", encoding="utf-8")as file:
            file.write(response.content.decode())


RequestCookie().getrequest()


