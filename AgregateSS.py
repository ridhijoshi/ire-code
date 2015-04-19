f=open("SessionSpan.dat",'r')
maxi=0
for i in f.readlines():
    i=float(i[:-1].split(",")[1])
    if i > maxi:
        maxi=i
f.seek(0)
w=open("AgregateSessionSpan.dat","w")
for i in f.readlines():
    i=i.split(",")
    n=str(float(i[1][:-1])/maxi)
    w.write(i[0]+","+n+"\n")
print "done"
