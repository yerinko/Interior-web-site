import numpy as np
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import cv2
from sklearn.externals import joblib
import json
from glob import glob
import time
from flask import Flask, request
import urllib


app = Flask(__name__)


def plot_colors(hist, centroids):

    bar = np.zeros((50, 300, 3), dtype="uint8")
    startX = 0

    for (percent, color) in zip(hist, centroids):
        endX = startX + (percent * 300)
        cv2.rectangle(bar, (int(startX), 0), (int(endX), 50),
                      color.astype("uint8").tolist(), -1)

        startX = endX

    return bar



@app.route('/colorList', methods=["GET","POST"])
def get_colorList():
    percentList = []
    colorList = []
    image = request.args.get('image_name')
    image = urllib.parse.unquote(image, 'utf-8')
    print("colorList 들어옴", image)

    time.sleep(1)
    #path = 'D:/bigdata/spring-workspace/SP_SJK/Interior/src/main/webapp/interior/furniture/'
    path = './data/furniture/'
    print("image: {}".format(path + image))

    image = cv2.imread(path + image)
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    image = image.reshape((image.shape[0] * image.shape[1], 3))  # height, width 통합

    k = 5
    clt = KMeans(n_clusters=k)
    clt.fit(image)

    numLabels = np.arange(0, len(np.unique(clt.labels_)) + 1)
    (hist, _) = np.histogram(clt.labels_, bins=numLabels)

    hist = hist.astype("float")
    hist /= hist.sum()
    hist
    #bar = plot_colors(hist, clt.cluster_centers_)

    for (percent, color) in (zip(hist, clt.cluster_centers_)):

        print(percent, color)
        percentList.append(percent)
        colorList.append(color)

    predList = []
    colorScore = []
    for i in colorList:

        pred = svmlabel2.predict(np.atleast_2d(i))
        predList.append(*pred)
        colorScore.append(i)
    print("predList :" , predList)

    import json
    fe = []
    #la = []
    for i in range(len(percentList)):
        label = {"pattern": "{}".format(colorScore[i]), "label": "{}".format(predList[i])}
        fe.append(label)
        la = {"cols": [*fe]}
        # label = {"id": "", "pattern": "{}".format(colorScore[i]), "label": "{}".format(predList[i]), "type": "number"}
        # value = {"v": percentList[i]}
        # fe.append(label)
        # la.append(value)
        # fosjon = {"cols": [{"id": "", "label": "colorPoint", "pattern": "", "type": "string"},
        #                    *fe],
        #           "rows": [{"c": [{"v": "percent"}, *la]}
        #                    ]
        #           }

    print(json.dumps(la))

    return (json.dumps(la))


@app.route('/bestColor', methods=["GET", "POST"])
def get_bestColor():

    image = request.args.get('image_name')
    image = urllib.parse.unquote(image,'utf-8')
    print(image)

    time.sleep(1)

    #path = 'D:/bigdata/spring-workspace/SP_SJK/Interior/src/main/webapp/interior/furniture/'
    path = './data/furniture/'
    print("image: {}".format(path + image))

    image = cv2.imread(path + image)
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    image = image.reshape((image.shape[0] * image.shape[1], 3))  # height, width 통합

    k = 5
    clt = KMeans(n_clusters=k)
    clt.fit(image)

    numLabels = np.arange(0, len(np.unique(clt.labels_)) + 1)
    (hist, _) = np.histogram(clt.labels_, bins=numLabels)

    hist = hist.astype("float")
    hist /= hist.sum()
    hist

    best_percent = 0

    for (percent, color) in zip(hist, clt.cluster_centers_):
        print(percent, color)
        if percent > best_percent:
            best_percent = percent
            if best_percent == percent:
                best_color = color

    print("best_percent,best_color : {},{}".format(best_percent, best_color))
    print("np.atleast_2d(best_color): {}".format(svmlabel2.predict(np.atleast_2d(best_color))))

    predict_number = svmlabel2.predict(np.atleast_2d(best_color))

    for number in predict_number:
        number

    print("number:", number)

    return str(number)


@app.route('/')
def hello_world():
    return "Hello World!"

if __name__ == '__main__' :
    svmlabel2 = joblib.load('./data/svmlabel2.pkl')

app.run()