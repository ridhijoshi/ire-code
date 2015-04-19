import pandas as pd
from sklearn import svm,cross_validation
from sklearn.ensemble import RandomForestClassifier
#train=pd.read_csv("finalData.dat")
test=pd.read_csv("finalDataTest.dat")
n=pd.DataFrame()
print "Read Test Data"
f=['l1','l3','l5','l7','l9','l11','l13','l15','l17','l19','l21']
for i in f:
    train=pd.read_csv("fd"+i)
    y=train['Label']
    train=train[['SIC','BT','SC','ST']]
    print "Start classification"
    clf=RandomForestClassifier(n_estimators=10)
    clf.fit(train,y)
    print "predicting"
    n[i]=clf.predict(test)
    print "writing to file"
    print i
n[f].to_csv("finaloutput",header=1,index=False)
    
'''
print "Read training"
#test=pd.read_csv("finalDataTest.dat")
print "Read testing"
y=train['Label']
print "Selected label"
#print y.loc[[2,3,4,5]]

#train=train[['SIC','BT','SC','ST']]
print "Selected Features"
#clf=RandomForestClassifier(n_estimators=10)
count=0
sss=cross_validation.StratifiedShuffleSplit(y,11,test_size=0.99)
clf_list=[]
for train_index,t in sss:
    #clf=svm.LinearSVC()
    print "init classifier"
    count=count+1
    train_index=train_index.tolist()
    #print train_index
    #X=train.loc[train_index]
    #Y=y.loc[train_index]
    #Y.to_csv("Y"+str(count),header=1)
    y=open("l"+str(count),"w")
    for i in train_index:
        y.write(str(i)+"\n")
    count+=1
    #clf.fit(X,Y)
    print "fit classifier"
    #clf_list.append(clf)
#pl=clf.predict(test)
#print pl
'''
