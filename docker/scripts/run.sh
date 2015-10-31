VERSION=${1:-1.0.0}
PORT=${2:-8080}
docker run -dit -p $PORT:8080 devops:$VERSION