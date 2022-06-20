#!/usr/bin/env python
# encoding: utf-8
import json
from joblib import load
from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/predict/targets', methods=['GET'])
def query_records():
    name = request.args.get('experience')
    print(name)
    experience = request.args.get('experience')
    print(experience)
    #forwardTo = experience
    #experience = float(experience)
    modelForward2 = load("../model-module/ExperienceForwardToModel.pkl")
    forwardTo = modelForward2.predict([[float(experience)]])
    modelSalary = load("../model-module/ExperienceSalaryModel.pkl")
    salary = modelSalary.predict([[float(experience)]])
    print(forwardTo)
    #return str(forwardTo);
    return jsonify({'experience': experience,
                    'salary': str(salary[0]),
                    'forwardTo': str(forwardTo[0])})
app.run(debug=True)