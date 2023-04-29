import re
import io

attendees = {}
# dictionary to create the map
with open("attendance.txt") as file:
# you need to have the file called attendance.txt so you don't get an error
    email_ad = file.readlines()

class Email:
    def __init__(self, emailStr=''):
        self.emailStr = emailStr
        
    def parseEmailName(self):
        pos = self.emailStr.index('@')
        name = self.emailStr[:pos]
        return name
        
    def parseCompanyName(self):
        pos = self.emailStr.index('@')
        #"rindex" = lastindexOf
        dot = self.emailStr.rindex('.')
        company = self.emailStr[pos+1:dot]
        return company
        
    def parseExtension(self):
        dot = self.emailStr.rindex('.')
        ext = self.emailStr[dot+1:]
        return ext

rawmp = {}
# dictionary to create the map

with open("attendance.txt") as file:

    scan = file.readlines()

for input in scan:
    al = []

    d_email = Email(input)
    
    name= d_email.parseEmailName()

    company= d_email.parseCompanyName()
    
    if company in rawmp:
        
        al = rawmp[company]

        al.append(name)

        # al.sorted()

        rawmp[company]=al

    else:
        al = []
        # list to create an array list
        al.append(name)

        rawmp[company] = al
