def solution(n):
    nums = []
    for i in range(len(str(n))):
        nums.append(int(n%10))
        n //= 10
    return nums