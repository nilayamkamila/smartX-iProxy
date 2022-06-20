from joblib import load

# Loading the Machine Learning Model
model = load("./ExperienceForwardToModel.pkl")

# Infinite Loop for the Prediction prompt
print("************ Salary Prediction App On Docker ************\n")
while True:
    # Taking the User Input
    experience = float(input("Enter your Years of Experience : "))
    result = model.predict([[experience]])

    # Rounding up the result to 2 Decimal Place
    forwardTo = round(*result, 0)

    print("This Request forwards to : {0}{1}\n".format("Proxy Host:", forwardTo))

    # Taking User Input for further Prediction
    choice = input("Do you want to continue [y/N]: ")
    if (choice == "N" or choice == "n"):
        break
    elif(choice == "Y" or choice == "y"):
        print()
    else:
        break