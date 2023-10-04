import socket

# 创建一个socket对象，AF_INET表示使用IPv4，SOCK_STREAM表示使用TCP
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 绑定到一个地址和端口，这里我们使用本地地址127.0.0.1和端口12345
server_socket.bind(('127.0.0.1', 12345))

# 开始监听连接，参数5表示可以挂起的最大连接数
server_socket.listen(5)

print('服务器启动，等待连接...')

# 接受一个连接
client_socket, client_address = server_socket.accept()

print(f'连接来自 {client_address}')

# 从客户端接收数据，并解码为字符串
data = client_socket.recv(1024).decode('utf-8')
print(f'收到数据: {data}')

# 向客户端发送数据
client_socket.send("你好，我是服务器！".encode('utf-8'))

# 关闭连接
client_socket.close()
server_socket.close()
