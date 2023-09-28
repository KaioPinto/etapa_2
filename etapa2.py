import requests as req
import pandas as pd
import mysql.connector
import pymongo
import json



#criando conexão
db_connection = mysql.connector.connect(host= 'localhost', user='root', password='759522', database='filme')
cursor = db_connection.cursor()
cliente = pymongo.MongoClient("mongodb://localhost:27017/")
#Filmes
#Busca de diretor e premios de um filme




criterio:str = str(input("Digite o critério de busca: "))
strTratada = criterio.replace(" ", "+")

key =  f'http://www.omdbapi.com/?s={strTratada}&apikey=a2bc1e25'
lista:list =req.get(key).json()["Search"]

variavel = 1
for item in lista:
    print( variavel,"-", (item["Title"]), "Ano:", item["Year"])
    variavel+=1


busca:str = input("Digite o nome do filme corretamente ").replace(" ", "+")
ano:int= int(input("Digite o ano: "))
url = f'http://www.omdbapi.com/?t={busca}&y={ano}&apikey=a2bc1e25'  
requisao = req.get(url).json()

titulo =requisao["Title"]
ano = requisao["Year"]
diretor = requisao["Director"]
filmes = cliente['filmes']
colecao = filmes['dados_filmes']

dados_filmes = {'Titulo': titulo, "Ano: ": ano, "Diretor: ":diretor}
c = colecao.insert_one(dados_filmes)

values = (titulo, ano, diretor)
sql = f"INSERT INTO filmes (titulo, ano, diretor) VALUES (%s, %s, %s) "  
cursor.execute(sql, values)
dataFrame= [{"Titulo": requisao["Title"],"Ano ": requisao["Year"],"Diretor ": requisao["Director"]


}]

cursor.close()
db_connection.commit()
db_connection.close()
bd = pd.DataFrame(dataFrame)
bd.to_csv("dados.csv", index=False)



print("concluido")


    

































  

        

