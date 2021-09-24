from collections import Counter
def solution(N, A, B):
    l = A + B 
    print(l)
    order = sorted(Counter(l).items(), key=lambda x: x[1], reverse=True)
    print(order)
    value = N
    count = 0
    for node in order:
        count = count + value * node[1]
        value = value - 1
    return count

print(solution(5, [2,2,1,2],[1,3,4,4]))