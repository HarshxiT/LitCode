class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        a=[]
        b=0
        for i in nums:
            if i==1:
                b+=1
            else:
                a+=[b]
                b=0
        a+=[b]
        b=0
        if len(a)==0:
            return (0)
        else:
            return (max(a))
        