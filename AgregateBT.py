f=open("BuyTime.dat",'r')
maxi=0
for i in f.readlines():
    i=float(i[:-1].split(",")[2])
    if i > maxi:
        maxi=i
f.seek(0)
w=open("AgregateBuyTime.dat","w")
for i in f.readlines():
    i=i.split(",")
    n=str(float(i[2][:-1])/maxi)
    w.write(i[0]+","+i[1]+","+n+"\n")
print "done"
