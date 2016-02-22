#####################################################################
# Fibonacci.py                                                      #
# Calculates the fibonacci numbers.  User inputs a number n, then   #
# program calculates the first n fibonacci numbers.                 #
# Uses Python 2.7                                                   #
#####################################################################

import timeit
#function to calculate the Fibonacci numbers with recursion
def calFib(n):
  if(n == 1 or n == 2):
    #if 1 or 2, have it return 1
    fibr=1
  elif(n == 0):
    #if 0, return 0
    fibr=0
  else:
    #return Nn-1 + Nn-2
    fibr=(calFib(n-1) + calFib(n-2))
  return fibr

def fibWithDP(n, fibList):
  fibr=0
  if(n == 1):
    #if 1, have it return 1
    fibr=+1
  elif(n == 0):
    #if 0, have it return 0
    fibr+=0
  else:
    #return Nn-1 + Nn-2
    if(fibList[n-2]):
      #use list to calculate next number in sequence
      fibr=fibList[n-2] + fibList[n-1]
    else:
      #if not in list, calculate it with recursion
      fibr+=(calFib(n-1) + calFib(n-2))
  fibList.append(fibr)
  return fibr

#Initialize variables, get user input
divider="##########################################################################"
fib=0
prevResult = 0
number = input("Please enter the number of Fibonacci numbers you want to calculate: ");

#####################################################################
#Use for loop for calculation                                       #
#####################################################################
print("Using only for loop...")
forStartTime = timeit.default_timer()
for i in range (0, number + 1):
  if(i == 1): fib=1
  print(str(i) + ". " + str(fib))

  # get the last two results
  if(i%2 == 0):
    prevResult2 = fib
  else:
    prevResult1 = fib 
  if(i >= 2):
    #calculate Fn-1 + Fn-2
    fib=prevResult1 + prevResult2
forElapsed = timeit.default_timer() - forStartTime

print(divider)
#####################################################################
#Use recursion and dynamic programming for calculation              #
#####################################################################
print("Now using recursion and dynamic programming...")
emptyList = list()
dpStartTime = timeit.default_timer()
for k in range (0, number + 1):
  answer = fibWithDP(k, emptyList)
  print(str(k) + ". " + str(answer))
dpElapsed = timeit.default_timer() - dpStartTime

print(divider)
#####################################################################
#Use only recursion for calculation                                 #
#####################################################################
print("Now using just recursion...")
recursionStartTime = timeit.default_timer()
for j in range (0, number + 1):
  print (str(j) + ". " + str(calFib(j)))
recursionElapsed = timeit.default_timer() - recursionStartTime


#####################################################################
#Print results                                                      #
#####################################################################
print(divider)
print("Results in seconds:")
print("Time used calculating with for loop:              " + str(forElapsed))
print("Time used with dynamic programming and recursion: " + str(dpElapsed))
print("Time used with just recursion:                    " + str(recursionElapsed))
print("Number of Fibonacci numbers calculated: " + str(number))
print(divider)
