import socket

# 创建一个socket对象
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 连接到服务器的地址和端口
client_socket.connect(('127.0.0.1', 12345))

# 向服务器发送数据
client_socket.send("你好，我是客户端！".encode('utf-8'))

# 从服务器接收数据，并解码为字符串
data = client_socket.recv(1024).decode('utf-8')
print(f'收到服务器的响应: {data}')

# 关闭socket
client_socket.close()
