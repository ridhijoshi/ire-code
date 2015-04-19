f=['l1','l3','l5','l7','l9','l11','l13','l15','l17','l19','l21']
m=open("TrainFile","r").readlines()
n=m[0]
m=m[1:]
for i in f:
    r=open(i,"r")
    b=open("BuyFile","r").read()
    w=open("fd"+i,"w")
    w.write(n)
    for j in r.readlines():
        j=int(j[:-1])
        w.write(m[j])
    w.write(b)
    print "Done",i
