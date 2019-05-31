import requests


class LoginRequests:

    def __init__(self):
        self.LoginUrl = "https://passport.csdn.net/login"
        self.LoginFormData = {
            "ck": " ",
            "name": "18217101618",
            "password": "88888888!",
            "remember": "false",
            "ticket": " "

        }
        self.headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36'
        }

    def Login(self):
        Session = requests.session()
        LoginResponse = Session.post(self.LoginUrl, data=self.LoginFormData, headers=self.headers)
        LoginHtml = LoginResponse.content.decode()
        with open("IsLoginSuccessful.html", "w", encoding="utf-8") as file:
            file.write(LoginHtml)
        print(LoginResponse.status_code)
        '''LoginCookies = LoginResponse.cookies
        data = Session.get("https://www.douban.com/people/147591365/", headers=self.headers)
        print(data.status_code)
        with open("BPersonal.html", "w", encoding="utf-8")as file:
            file.write(data.content.decode())'''


if __name__ == "__main__":
    LoginRequests().Login()
