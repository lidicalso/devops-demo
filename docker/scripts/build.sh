DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
VERSION=${1:-1.0.0}
docker build -t devops:$VERSION $DIR/../image