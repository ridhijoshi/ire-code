f=open("dataset/yoochoose-test.dat","r")
fs=open("dataset/yoochoose-buys.dat","r")
l={}
ls={}
b={}
sd={}
for i in f.readlines()[1:]:
    i=i[:-1].split(',')
    if i[2] not in l:
        l[i[2]]=1
    else:
        l[i[2]]+=1
f.close()
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
print len(ls)
f=open("dataset/yoochoose-test.dat","r")
nf=open("yogesh/ICSTest.dat","r")
e=nf.readlines()
a=f.readlines()
cptr=open("NewPredictedLabel.csv","r")
b=cptr.readlines()
out=open("FilterNewPredictedResult.csv","w")
c=0
d=0
for i in range(1,len(a)):
    try:
        s=a[i].split(',')[2] 
        click=int(e[i][:-1])
        if s in ls:
            #out.write(b[i])
            if ls[s]>=10 and click>=2:
                c+=1
                out.write("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1\n")
            else:
                #out.write(b[i])
                d+=1
                out.write("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n")
        else:
            #out.write(b[i])
            d+=1
            out.write("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n")
    except:
        print c,d,c+d
        break


print c,d,c+d
