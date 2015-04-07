import datetime
#f=open("../dataset/yoochoose-clicks.dat","r")
f=open("../dataset/yoochoose-test.dat","r")
t=open("SessionSpanTest.dat","w")
currSession="-1"
initialtd="0"
diff="0"
def compute(s1,s2):
    #print s1.split(".")[0]
    t1=datetime.datetime.strptime(s1.split(".")[0],"%Y-%m-%dT%H:%M:%S")
    t2=datetime.datetime.strptime(s2.split(".")[0],"%Y-%m-%dT%H:%M:%S")
    t3=t1-t2
    return str(t3.total_seconds())
for i in f.readlines()[1:]:
    i=i.split(",")
    if i[0]!=currSession:
        if currSession!="-1":
            t.write(currSession+","+diff+"\n")
        currSession=i[0]
        initialtd=i[1]
    try:
        diff=compute(i[1],initialtd)
    except:
        print "error"
t.write(currSession+","+diff+"\n")
