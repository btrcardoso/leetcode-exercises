# https://www.w3schools.com/python/python_datatypes.asp

x = "Hello World"	# str
print(x)

x = 20	# int
print(x)

x = 20.5	# float
print(x)

x = 1j	# complex
print(x)

x = ["apple", "banana", "cherry"]	# list
print(x)

x = ("apple", "banana", "cherry")	# tuple
print(x)

x = range(6)	# range
print(x)

x = {"name" : "John", "age" : 36}	# dict
print(x)

x = {"apple", "banana", "cherry"}	# set
print(x)

x = frozenset({"apple", "banana", "cherry"})	# frozenset
print(x)

x = True	# bool
print(x)

x = b"Hello"	# bytes
print(x)

x = bytearray(5)	# bytearray
print(x)

x = memoryview(bytes(5))	# memoryview
print(x)

x = None	# NoneType
print(x)


import random
print(random.randrange(1,10))


for x in "banana":
    print(x)
print(len("banana"))


print("cde" in "abcdefg") # True


text = "abcdef"
print(text[1:4])    # bcd
print(text[:4])     # abcd
print(text[-5:-2])  # bcd
# [included, not included]

a = " Hello, World! "
print(a.upper())
print(a.lower())
print(a.strip()) # remove whitespace from beggining and the end



# Concatenate
a = "oi, "
b = "como vai?"
print(a+b)


'''
# wrong

a = "oi, "
b = 1
print(a+b)

'''

age = 36
txt = f"My name is John, I am {age} years old"
print(txt)

price = 10
txt = f"The price is {price:.2f} dollars"
print(txt)

txt = "We are so-called \"Vikings\" form the north"
print(txt)

'''
python string methods 
https://www.w3schools.com/python/python_strings_methods.asp
'''


print(bool("Hello")) # True
print(bool(15))      # True
print(bool(0))       # False

print(isinstance(200, int))

# x=3
# print(x)
print(x:=3)

numbers = [1,2,3]
if (count:=len(numbers)) > 2:
    print(f"List has {count} elements, which is bigger than 2")

num = 6
x = "WEEKEND!" if num > 5 else "Workday"
print(x)



x = ["apple"]
y = ["apple"]
z = x
print(x is y)
print(x is z)
print(x == y)
print("apple" in x)


print(6 & 3) # 110 & 011 = 010 => 2   AND
print(6 | 3) # 110 | 011 = 111 => 7   OR
print(6 ^ 3) # 110 ^ 011 = 101 => 5   XOR

















