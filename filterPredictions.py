f=open("dataset/yoochoose-test.dat","r")
fs=open("dataset/yoochoose-buys.dat","r")
ics=open("yogesh/ICSTest.dat","r")
e=ics.readlines()
l={}
ls={}
b={}
sd={}
for i in fs.readlines()[1:]:
    i=i[:-1].split(",")
    if i[0] not in sd:
        sd[i[0]]=1
    if i[2] not in ls:
        ls[i[2]]=1
    else:
        ls[i[2]]+=1
fs.close()
currS="-1"
booli=0
fl={}
sl=[]
newD={}
print len(ls)
a=f.readlines()
for i in range(1,len(a)):
    s=a[i].split(",")[2]
    click=int(e[i][:-1])
    if s in ls:
       if click > 2:
           if s not in newD:
               newD[s]=1
           else:
               newD[s]+=1

f.close()
fs.close()
f=open("dataset/yoochoose-test.dat","r")
ics=open("yogesh/ICSTest.dat","r")
a=f.readlines()
e=ics.readlines()
cptr=open("NewPredictedLabel.csv","r")
b=cptr.readlines()
out=open("FilterNewPredictedResult.csv","w")
for i in range(1,len(a)):
    s=a[i].split(',')[2] 
    click=int(e[i][:-1])
    if s in newD:
        #out.write(b[i])
        if ls[s]>=10 and newD[s]>=700:
            out.write("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1\n")
        else:
            #out.write(b[i])
            out.write("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n")
    else:
        #out.write(b[i])
        out.write("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n")


