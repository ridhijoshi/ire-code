import datetime
#f=open("../dataset/yoochoose-clicks.dat","r")
f=open("../dataset/yoochoose-test.dat","r")
t=open("BuyTimeTest.dat","w")
currSession="-1"
initialtd={}
diff={}
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
            for j in diff:
                t.write(currSession+","+j+","+diff[j]+"\n")
                #print "success"
        currSession=i[0]
        initialtd={}
        diff={}
        initialtd[i[2]]=i[1]
    else:
        if not i[2] in initialtd:
            initialtd[i[2]]=i[1]
    try:
        diff[i[2]]=compute(i[1],initialtd[i[2]])
    except:
        print "error"
for j in diff:
    t.write(currSession+","+j+","+diff[j]+"\n")
print "Done"
