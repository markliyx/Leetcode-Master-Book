def solution(K, A):
    # write your cdode in Python 3.6
    count = 0
    for i in range(len(A)): 
        for j in range(len(A[i])): 
            if isValid(K, A, j, i) and A[i][j] == 0: 
                count = count + 1
    return count   

def isValid(K, A, x, y):
    for i in range(len(A)): 
        for j in range(len(A[i])): 
            if A[i][j] == 1:
                if (abs(i - y) + abs(j - x)) > K:
                    return False
    return True

test = [[0,1],[0,0]]

print(solution(1, test))