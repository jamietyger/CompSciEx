import csv
import json

def main():
    fileopen()
    #eCapitals = question1()
    #question2(eCapitals)
    #question3()
    #question4()

def fileopen():
     csv_rows = []
    with open(file) as csvfile:
        reader = csv.DictReader("world.csv")
        title = reader.fieldnames
        for row in reader:
            csv_rows.extend([{title[i]:row[title[i]] for i in range(len(title))}])
        write_json(csv_rows, json_file, pretty)

def question1():
    print("Question 1:")
    csvRows = []
    csvFile = open("world.csv")
    csvReader = csv.reader(csvFile)
    for row in csvReader:
        if csvReader.line_num == 1:
            continue    # skip first row
        if (row[12]).endswith("e"):
            csvRows.append(row[12])  # Append Capitals ending with 'e'

    csvFile.close()
    eset = set(csvRows)
    eCapitals = list(eset)
    print len(eCapitals)
    return eCapitals


def question2(eCapitals):
    print("\nQuestion 2:")
    print("\n".join(eCapitals))


def question3():
    csvRows = []
    csvFile = open("world.csv")
    csvReader = csv.reader(csvFile)
    for row in csvReader:
        if csvReader.line_num == 1:
            continue    # skip first row
        if row[6]=="NULL":
            continue
        if (int(row[6])>=1950) and (int(row[6])<=1970):
            csvRows.append(row[2])  # Append Country
    csvFile.close()
    cset = set(csvRows)
    indynames = list(cset)
    print("\nQuestion 3:")
    print len(indynames)

def question4():
        csvRows = []
        csvFile = open("world.csv")
        csvReader = csv.reader(csvFile)
        for row in csvReader:
            if csvReader.line_num == 1:
                continue    # skip first row
            if row[6]=="NULL":
                continue
            if (int(row[6])>=1830) and (int(row[6])<=1850):
                csvRows.append(row[2])  # Append Country
        csvFile.close()
        cset = set(csvRows)
        indynames = list(cset)
        print("\nQuestion 4:")
        print("\n".join(indynames))

def question5():

    csvRows = []
    csvFile = open("world.csv")
    csvReader = csv.reader(csvFile)
    for row in csvReader:
        if csvReader.line_num == 1:
            continue    # skip first row
        if row[6]=="NULL":
            continue
        if (int(row[6])>=1830) and (int(row[6])<=1850):
            csvRows.append(row[2])  # Append Country
    csvFile.close()
    cset = set(csvRows)
    indynames = list(cset)
    print("\nQuestion 5:")
    print("\n".join(indynames))








def question6():




def question7():




def question8():


main()
