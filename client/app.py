from tkinter import *
import requests
import json

root = Tk()

Label(text='#').grid(row=0, column=0)
Label(text='ФИО').grid(row=0, column=1)
response = requests.get('http://localhost:8080/journal')
print(response.text)
unique_students = list(set([st['studentFullName'] for st in json.loads(response.text)]))
unique_subjects = list(set([st['subjectShortName'] for st in json.loads(response.text)]))
print(unique_subjects)
for i, sub in enumerate(unique_subjects):
    Label(text=sub).grid(row=0, column=i + 2)

unique_records = {}
for st in unique_students:
    unique_records[st] = {}
for record in json.loads(response.text):
    unique_records[record['studentFullName']][record['subjectShortName']] = {"examType": record["examType"],
                                                                             "markName": record["markName"],
                                                                             "count": record["count"],
                                                                             "markId": record["markId"]}
print(unique_records)

for i, rec in enumerate(unique_records):
    Label(text=i + 1).grid(row=i + 1, column=0)
    Label(text=rec).grid(row=i + 1, column=1)
    for j, exam in enumerate(unique_subjects):
        if exam in unique_records[rec]:
            bg = "White"
            fg = "Black"
            if unique_records[rec][exam]['markId'] in [4, 6]:
                bg = "Black"
                fg = "White"
            Label(bg=bg, fg=fg, text=unique_records[rec][exam]['examType'] + ':' + unique_records[rec][exam][
                'markName'] + '\nПересдач:' + str(unique_records[rec][exam]['count'] - 1)).grid(
                row=i + 1, column=j + 2)
            print(unique_records[rec][exam]['markName'], i + 1, j + 2)

root.mainloop()
