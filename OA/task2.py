def solution(S):
    # write your code in Python 3.6
    # use stack 
    stack = []
    for c in S:
        if stack:
            prev = stack.pop()
            s = prev + c
            if s != "AB" and s != "BA" and s != "CD" and s != "DC":
                stack.append(prev)
                stack.append(c)
        else: 
            stack.append(c)
    print(stack)
    return ''.join(stack)

print(solution('ACBDACBD'))