import pandas as pd
import matplotlib.pyplot as plt

# Ler os resultados do arquivo de texto
with open("resultados_800k.txt", "r") as file:
    lines = file.readlines()

# Separar os resultados por método
bubble_sort_results = [int(line.split(", ")[2].split(" ")[0]) for line in lines if "Bubble Sort" in line]

# Construir dataframe com os resultados
df = pd.DataFrame({"Teste": range(1, 21), "Tempo Bubble Sort (ms)": bubble_sort_results})

# Criar gráfico para Bubble Sort
plt.figure(figsize=(10, 6))
plt.plot(df["Teste"], df["Tempo Bubble Sort (ms)"], marker='o', linestyle='-')
plt.title("Desempenho do Bubble Sort")
plt.xlabel("Teste")
plt.ylabel("Tempo (ms)")
plt.grid(True)
plt.show()

# Análise 3.1 - Comportamento de cada método individualmente
# Para o Bubble Sort, podemos observar...

# Análise 3.2 - Comparação de desempenho entre métodos
# Para comparar o desempenho entre métodos...
