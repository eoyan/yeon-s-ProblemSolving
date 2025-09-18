str = input()
result = ""

for c in str:
    if c.islower():
        result += c.upper()
        
    elif c.isupper(): 
        result += c.lower()
        
print(result)
        