from setuptools import setup, find_packages

setup(
    name='apiverve_romannumeralmath',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Roman Numeral Math is a tool for performing mathematical operations (add, subtract, multiply, divide) with Roman numerals. It shows both numeric and Roman numeral equations.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
