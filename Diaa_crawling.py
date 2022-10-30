#!/usr/bin/env python
# coding: utf-8

# In[7]:


from selenium.webdriver import Chrome
from selenium import webdriver
import time
import os
import pandas as pd
import re
from selenium import webdriver
#팝업창
from selenium.webdriver.common.alert import Alert
from selenium.common.exceptions import NoSuchElementException


# In[180]:


#옵션설정|
options = webdriver.ChromeOptions()

options.add_argument("--start-maximized")


# In[181]:


driver = webdriver.Chrome(executable_path=r"C:\chromedriver.exe", options=options)
driver.implicitly_wait(3) #웹페이지 전체가 넘어올때까지 기다리기


# In[182]:


#url 접근
driver.get('http://diaa.kised.or.kr/routine')
time.sleep(1)


# In[183]:


company = []
adr = []
name = []


# In[184]:


for j in range(2,13):
    try:
        path2 = '//*[@id="divaInfo"]/div[3]/table/tbody/tr[{0}]/td[3]/a'.format(j)
        driver.find_element_by_xpath(path2).click()
        driver.switch_to.window(driver.window_handles[1])

        a = driver.find_element_by_xpath('/html/body/div[2]/table/tbody/tr[1]/td')
        #time.sleep(1)
        b = driver.find_element_by_xpath('/html/body/div[2]/table/tbody/tr[5]/td')
        #time.sleep(1)
        c = driver.find_element_by_xpath('/html/body/div[2]/table/tbody/tr[6]/td[2]')
        #time.sleep(1)
        
    
        company.append(a.text)
        adr.append(b.text)
        if len(c.text) < 1:
            name.append('')
        else:
            name.append(c.text)
    
        driver.find_element_by_xpath('//*[@id="popclose"]/img').click()
        driver.switch_to.window(driver.window_handles[0])
        time.sleep(1)
        
        
    
    except NoSuchElementException:
        break


# In[185]:


while True:
    for i in range(4,9):
        path1 = '//*[@id="divaInfo"]/div[3]/div/div[{0}]'.format(i)
        driver.find_element_by_xpath(path1).click()
        time.sleep(1)
        #페이지 크롤링 
        for j in range(2,13):
            try:
                path2 = '//*[@id="divaInfo"]/div[3]/table/tbody/tr[{0}]/td[3]/a'.format(j)
                driver.find_element_by_xpath(path2).click()
                driver.switch_to.window(driver.window_handles[1])

                a = driver.find_element_by_xpath('/html/body/div[2]/table/tbody/tr[1]/td')
                time.sleep(1)
                b = driver.find_element_by_xpath('/html/body/div[2]/table/tbody/tr[5]/td')
                #time.sleep(1)
                c = driver.find_element_by_xpath('/html/body/div[2]/table/tbody/tr[6]/td[2]')
                time.sleep(1)
        
    
                company.append(a.text)
                adr.append(b.text)
                if len(c.text) < 1:
                    name.append('')
                else:
                    name.append(c.text)
    
                driver.find_element_by_xpath('//*[@id="popclose"]/img').click()
                driver.switch_to.window(driver.window_handles[0])
                time.sleep(1)
        
        
    
            except NoSuchElementException:
                break


# In[186]:


print(name)


# In[ ]:




