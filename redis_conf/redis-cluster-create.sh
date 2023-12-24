# tells Redis nodes how to connect to each other in the cluster
# wait for the docker-compose depends_on to spin up. The redis nodes usually takes this long
sleep 10

# in docker compose, the host names are the same as the service names
# 'getent' enumerates the hosts on your network. Here it's used to enumerate the hosts in the Docker network
node_1_ip=$(getent hosts redis-cluster-node1 | awk '{ print $1 }')

node_2_ip=$(getent hosts redis-cluster-node2 | awk '{ print $1 }')

node_3_ip=$(getent hosts redis-cluster-node3 | awk '{ print $1 }')

node_4_ip=$(getent hosts redis-cluster-node4 | awk '{ print $1 }')

node_5_ip=$(getent hosts redis-cluster-node5 | awk '{ print $1 }')

node_6_ip=$(getent hosts redis-cluster-node6 | awk '{ print $1 }')

redis-cli \
  --cluster create \
  $node_1_ip:6379 \
  $node_2_ip:6379 \
  $node_3_ip:6379 \
  $node_4_ip:6379 \
  $node_5_ip:6379 \
  $node_6_ip:6379 \
  --cluster-replicas 1 \
  --cluster-yes