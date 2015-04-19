import numpy as np
import math;
import matplotlib.pyplot as plt;
def getTime(z):
	z=z.split(":");
	value=int(0);
	value =int(int(z[0])*3600+int(z[1])*60+int(math.floor(float(z[2]))));
	return value;


#fd = open("./yoochoose-buys.dat", 'r');

i=0;

x1=[i1 for i1 in range(24)];
y1=[0 for j1 in range(24)];
yz=[];
y1=[2837, 1876, 1757, 2577, 7533, 19856, 39704, 60322, 73437, 77279, 73663, 74494, 69892, 63991, 65134, 68790, 68810, 75876, 89170, 89525, 66857, 36104, 15423, 5846];

#x2 = np.arange(0, 86401, 3600);
#y2 = np.sin(x2);
#plt.plot(x2, y2)
print i;
print x1;
print y1;

y11=[155359, 105322, 102394, 149191, 391717, 850077, 1339638, 1711323, 1938499, 2057423, 1983532, 1947142, 1842362, 1736459, 1789400, 1832844, 1853151, 2079167, 2421257, 2562235, 2079734, 1199026, 594388, 282304];

print y11;
#plot_l, = plt.plot(x1, y1, 'bo');
#hours_l, = plt.plot(x2, y2, '')
#plt.barh(y1, x1, align='center', alpha=0.4);
yz=[0 for i in range(24)];
for i in range(24):
	yz[i]=float(y1[i])/float(y11[i])*1000.00;


ind = np.arange(24);
width=0.35;

fig, ax = plt.subplots();
rects1 = ax.bar(ind, yz, width, color='r')

plt.show();
