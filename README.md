# pipe
该系统主要包括excel解析、邮件短信推送、网页爬虫、推送管理等模块。

首先用户上传固定格式的excel并解析，保存数据后在爬虫数据库中查询，

如果有字段则进行邮件短信推送，

如果没有则进行网页爬虫模块，由于该模块运行时间较长，放入线程中，提前给用户反馈，

爬虫完后再查询，向查出的供货商进行邮件短信推送，

运营方可以查看每个excel的报价详情，每个型号的不同供货商的报价和供货商的详细信息，

还可以查看供货商访问报价页的记录，如果没有报价，也可以进行人为跟进。
