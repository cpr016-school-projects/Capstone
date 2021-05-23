#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
CREATE SQL SCRIPT FROM PATIENT INFO PROVIDED BY CONSULTING REGISTER
"""

import json
import pandas as pd
import numpy as np

prefix = ''
json_path =  prefix + '20kpatients.json'


## load CR json, filter 


with open(json_path, 'rb') as f:
    patient_dict = json.load(f)
    
patients = pd.DataFrame.from_dict(patient_dict, orient="index")

patients = patients[patients.gender != 'Male']
patients = patients[patients.firstName.notnull()]
patients = patients[patients.lastName.notnull()]
patients = patients[patients.NHISNumber.notnull()]
patients = patients.fillna(value={"gender":"", "tribe":"", "age":0})
patients['gender'] = patients['gender'].astype(np.str)
patients['tribe'] = patients['tribe'].astype(np.str)



patients['age'] = patients['age'].astype(np.int16)
patients['NHISNumber'] = patients['NHISNumber'].astype(np.int32)


n = len(patients)

## define sql statements 


build_table = "CREATE TABLE IF NOT EXISTS BasePatient \n" +\
            "(entityId SERIAL PRIMARY KEY, firstName VARCHAR(255), \n" +\
            "lastName VARCHAR(255), gender VARCHAR(10), tribe VARCHAR(255), \n"+\
            "address VARCHAR(255), NHISnumber INT, age INT);\n"

insert_stmt = "INSERT INTO BasePatient \n"+\
            "(firstName, lastName, gender, tribe, address, NHISnumber, age) VALUES \n"
            


       
    
with open(prefix + 'load_patients_v2.sql', 'w') as f:
    f.write(build_table)
    f.write(insert_stmt)
    for i in range(n):
        if i%100 == 0:
            print(i)
        obs = patients.iloc[i]
        firstname = obs['firstName']
        lastname = obs['lastName']
        gender = obs['gender']
        tribe = obs['tribe']
        nhis = obs['NHISNumber']
        address = obs['address']
        age = obs['age']
        
        
        keys = [k for k in address.keys()]
        adstr = ""
        for k in keys:
            adstr += k + ":" + address[k] + " "
            
        value = "(" + "\'" + firstname + "\'" + "," + "\'" + lastname + "\'" + "," + "\'" + gender + "\'" + "," + "\'" + tribe + "\'" + "," + "\'" + adstr + "\'" + "," + str(int(nhis)) + "," + str(int(age)) + ")"
        
        if i == (n-1):
            value += '\n;'
        else:
            value += ',\n'
        f.write(value)
            
        
          
        
            