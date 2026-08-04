

print("hi")
if 5 > 3:
    print("nothing")

print("I am ", 24, " years old")


'''
comment

'''

# comment

x = str(3)   # '3'
y = int("3") # 3
z = float(3) # 3.0
print(x)
print(y)
print(z)
print(type(x))
print(type(y))
print(type(z))

x,y,z = 1,2,3
x=y=z = "Orange"

fruits = ["apple", "banana"]
a,b = fruits
print(a)
print(b)


x="awesome"
def myFunc():
    global x
    x = "fantastic"
myFunc()
print("Python is " + x)