import time
from flask import Flask


app = Flask(__name__)

def get_hit_count():
    retries = 5
    while True:
        try:
            return cache.incr('hits')
        except redis.exceptions.ConnectionError as exc:
            if retries == 0:
                raise exc
            retries -= 1
            time.sleep(0.5)


@app.route('/')
def hello():
    return 'Hello from E34!'

if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True)
