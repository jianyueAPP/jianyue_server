#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
__title__  = choosearticle.py 
__author__ = yupeng
__time__   = 2017-11-16 16:15 

"""
import json
import pymysql
import random
import sys

conn = pymysql.connect(host='127.0.0.1', user='jianyue', passwd='123456789', db='jianyue', port=3306, charset='utf8')
cur = conn.cursor()
article = list()
for i in range(1, len(sys.argv)):
    cur.execute("select * from t_article where tag = \"" + sys.argv[i] + "\" and status = 1")  # modify
    results = cur.fetchall()
    result = list(results)
    for ele in result:
        article.append(ele)
#for ele in article:
    #print(ele)
random.shuffle(article)
if len(article):
    data = {"title": article[0][1], "author": article[0][2], "link": article[0][3], "tag": article[0][4]}
    in_json = json.dumps(data)
    print(in_json)
# for i in range(0, 5):
#	random.shuffle(result)
#	a.append(result[0])
# print(a[0])
#print('ok')
