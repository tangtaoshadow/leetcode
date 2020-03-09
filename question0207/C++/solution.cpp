class Solution {
	public:
		bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
			int inDegree[numCourses] = {0};	//��¼ÿ���ڵ�����
			vector<int> graph[numCourses];
			for(int i = 0; i < prerequisites.size(); i++) {
				graph[prerequisites[i].second].push_back(prerequisites[i].first);
				inDegree[prerequisites[i].first]++;
			}
			int num = 0;	//��¼�����������еĶ�����
			queue<int> q;
			for(int i = 0; i < numCourses; i++) {
				if(inDegree[i] == 0) {
					q.push(i);	//���������Ϊ0�Ķ������
				}
			}
			while(!q.empty()) {
				int u = q.front();	//ȡ���׶���u
				q.pop();
				for(int i = 0; i < graph[u].size(); i++) {
					int v = graph[u][i];	//u�ĺ�̽ڵ�v
					inDegree[v]--;	//����v����ȼ�1
					if(inDegree[v] == 0) {
						q.push(v);	//����v����ȼ�Ϊ0�����
					}
				}
//				graph[u].clear(); 
				num++;
			}
			if(num == numCourses){
				return true;	//�����������еĶ�����ΪnumCourses��˵����������ɹ� 
			}
			return false;	//�����������еĶ�����С��numCourses��˵����������ʧ�� 
		}
};
